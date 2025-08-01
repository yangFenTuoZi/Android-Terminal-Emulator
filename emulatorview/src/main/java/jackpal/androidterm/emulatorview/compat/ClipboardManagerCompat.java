package jackpal.androidterm.emulatorview.compat;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;

public class ClipboardManagerCompat {
    private final ClipboardManager clip;

    public ClipboardManagerCompat(Context context) {
        clip = (ClipboardManager) context.getApplicationContext()
                .getSystemService(Context.CLIPBOARD_SERVICE);
    }

    public CharSequence getText() {
        ClipData.Item item = clip.getPrimaryClip().getItemAt(0);
        return item.getText();
    }

    public boolean hasText() {
        return (clip.hasPrimaryClip() && clip.getPrimaryClipDescription()
                .hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN));
    }

    public void setText(CharSequence text) {
        ClipData clipData = ClipData.newPlainText("simple text", text);
        clip.setPrimaryClip(clipData);
    }
}
