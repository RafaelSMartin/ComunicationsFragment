package com.rafaels.lifecicle;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.InputType;
import android.widget.Toast;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.StackingBehavior;

/**
 * Created by Indogroup02 on 02/02/2018.
 */

public class CustomDialog extends DialogFragment {

    private Context context;
    private OnCompleteListener mListener;

    private static String customTitleDialog, customTextDialog;
    private static int modo;
    private String text = "";


    public static void startCustomDialog(Activity startingActivity, String customTitle, String customText, String textProfile, int mode)
    {
        CustomDialog customDialog = new CustomDialog();
        customTitleDialog = customTitle;
        customTextDialog = customText+textProfile;
        modo = mode;
        customDialog.show(startingActivity.getFragmentManager(), "CustomDialog");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        context = getActivity();


        MaterialDialog customMaterialDialog = new MaterialDialog.Builder(getActivity())
                .title(customTitleDialog)
                .content(customTextDialog)
                .stackingBehavior(StackingBehavior.ADAPTIVE)
                .inputType(
                        InputType.TYPE_CLASS_TEXT
                                | InputType.TYPE_TEXT_VARIATION_PERSON_NAME
                                | InputType.TYPE_TEXT_FLAG_CAP_WORDS)
                .positiveText(R.string.custom_submit)
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                        mListener.onCompleteCustomDialog(text, modo);

                    }
                })
                .alwaysCallInputCallback() // this forces the callback to be invoked with every input change
                .inputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME)
                .input(R.string.custom_input_hint, 0, new MaterialDialog.InputCallback() {
                    @Override
                    public void onInput(@NonNull MaterialDialog dialog, CharSequence input) {
                        if (input.toString().equalsIgnoreCase("")) {
                            dialog.setContent(customTextDialog);
                            dialog.getActionButton(DialogAction.POSITIVE).setEnabled(false);
                            text = input.toString();
                            if (text.length()>3){
                                dialog.getActionButton(DialogAction.POSITIVE).setEnabled(true);
                            } else{
                                dialog.getActionButton(DialogAction.POSITIVE).setEnabled(false);
                            }
                        } else {
                            dialog.setContent(customTextDialog);
                            dialog.getActionButton(DialogAction.POSITIVE).setEnabled(true);
                            text = input.toString();
                            if (text.length()>3){
                                dialog.getActionButton(DialogAction.POSITIVE).setEnabled(true);
                            } else{
                                dialog.getActionButton(DialogAction.POSITIVE).setEnabled(false);
                            }
                        }
                    }
                })
                .negativeText(R.string.custom_cancel)
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                    }
                })
                .cancelable(false)
                .build();
        return customMaterialDialog;

    }


    public  interface OnCompleteListener {
        void onCompleteCustomDialog(String text, int modo);
    }


    // make sure the Activity implemented it
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.mListener = (OnCompleteListener)activity;
        }
        catch (final ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnCompleteListener");
        }
    }

}
