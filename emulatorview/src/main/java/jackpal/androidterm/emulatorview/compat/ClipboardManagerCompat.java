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
        ClipData clipData = clip.getPrimaryClip();
        if (clipData == null || clipData.getItemCount() == 0) {
            ClipData.Item item = clip.getPrimaryClip().getItemAt(0);
            return item.getText();
        } else {
            return null;
        }
    }

    public boolean hasText() {
        ClipDescription clipDescription = clip.getPrimaryClipDescription();
        boolean hasMimeType = false;
        if (clipDescription != null) {
            hasMimeType = clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN);
        }
        return (clip.hasPrimaryClip() && hasMimeType);
    }

    public void setText(CharSequence text) {
        ClipData clipData = ClipData.newPlainText("simple text", text);
        clip.setPrimaryClip(clipData);
    }
}
