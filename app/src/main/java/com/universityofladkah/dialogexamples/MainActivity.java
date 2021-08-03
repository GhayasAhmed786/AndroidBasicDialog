package com.universityofladkah.dialogexamples;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {
    private static final String[] COLORS = {"Red", "Green", "Blue", "Purple", "Olive"};
    /* access modifiers changed from: private */
    public static final String[] RINGTONE = {"None", "Callisto", "Ganymede", "Luna"};
    /* access modifiers changed from: private */
    public boolean[] clicked_colors = new boolean[COLORS.length];
    /* access modifiers changed from: private */
    public View parent_view;
    /* access modifiers changed from: private */
    public String single_choice_selected1;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_main);
        this.parent_view = findViewById(R.id.nested_scroll_view);

    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.material.components.activity.dialog.DialogBasic, android.app.Activity] */
    private void viewsetter() {
        findViewById(R.id.confirm_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAction(view);
            }
        });
        findViewById(R.id.alert_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAction(view);
            }
        });
        findViewById(R.id.single_choice_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAction(view);
            }
        });

        findViewById(R.id.multi_choice_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickAction(view);
            }
        });

    }





    public void clickAction(View view) {
        switch (view.getId()) {
            case R.id.alert_dialog:
                showAlertDialog();
                return;
            case R.id.confirm_dialog:
                showConfirmDialog();
                return;
            case R.id.multi_choice_dialog:
                showMultiChoiceDialog();
                return;
            case R.id.single_choice_dialog:
                showSingleChoiceDialog();
                return;
            default:
                return;
        }
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, com.material.components.activity.dialog.DialogBasic] */
    private void showConfirmDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Use Google's location services ?");
        builder.setMessage("Before proceding to further using google service please agree the policies");
        builder.setPositiveButton("Agree", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Agree clicked",Toast.LENGTH_LONG).show();

            }
        });
        builder.setNegativeButton("Disagree", (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [android.content.Context, com.material.components.activity.dialog.DialogBasic] */
    private void showAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Discard draft ?");
        builder.setPositiveButton("Discard", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Discard clicked",Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("Cancel", (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.content.Context, com.material.components.activity.dialog.DialogBasic] */
    private void showSingleChoiceDialog() {
        String[] strArr = RINGTONE;
        this.single_choice_selected1 = strArr[0];
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Phone Ringtone");
        builder.setSingleChoiceItems(strArr, 0, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                String unused = single_choice_selected1 = RINGTONE[i];
            }
        });
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Selected:    "+single_choice_selected1,Toast.LENGTH_LONG).show();

            }
        });
        builder.setNegativeButton("Cancel", (DialogInterface.OnClickListener) null);
        builder.show();
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [android.content.Context, com.material.components.activity.dialog.DialogBasic] */
    private void showMultiChoiceDialog() {
        this.single_choice_selected1 = RINGTONE[0];
        String[] strArr = COLORS;
        this.clicked_colors = new boolean[strArr.length];
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Your preferred colors");
        builder.setMultiChoiceItems(strArr, this.clicked_colors, new DialogInterface.OnMultiChoiceClickListener() {
            public void onClick(DialogInterface dialogInterface, int i, boolean z) {
           clicked_colors[i] = z;
            }
        });
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this,"Your choice is submited sucessfully",Toast.LENGTH_LONG).show();

            }
        });
        builder.setNegativeButton("cancel", (DialogInterface.OnClickListener) null);
        builder.show();
    }
}
