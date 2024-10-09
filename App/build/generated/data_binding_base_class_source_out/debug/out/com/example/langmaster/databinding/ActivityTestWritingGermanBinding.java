// Generated by view binder compiler. Do not edit!
package com.example.langmaster.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.langmaster.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityTestWritingGermanBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final EditText antwortEditText;

  @NonNull
  public final TextView falscheAntwortTextView;

  @NonNull
  public final Button korrekteAntwortButton;

  @NonNull
  public final TextView satzTextView;

  private ActivityTestWritingGermanBinding(@NonNull RelativeLayout rootView,
      @NonNull EditText antwortEditText, @NonNull TextView falscheAntwortTextView,
      @NonNull Button korrekteAntwortButton, @NonNull TextView satzTextView) {
    this.rootView = rootView;
    this.antwortEditText = antwortEditText;
    this.falscheAntwortTextView = falscheAntwortTextView;
    this.korrekteAntwortButton = korrekteAntwortButton;
    this.satzTextView = satzTextView;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTestWritingGermanBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTestWritingGermanBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_test_writing_german, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTestWritingGermanBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.antwort_edit_text;
      EditText antwortEditText = ViewBindings.findChildViewById(rootView, id);
      if (antwortEditText == null) {
        break missingId;
      }

      id = R.id.falsche_antwort_text_view;
      TextView falscheAntwortTextView = ViewBindings.findChildViewById(rootView, id);
      if (falscheAntwortTextView == null) {
        break missingId;
      }

      id = R.id.korrekte_antwort_button;
      Button korrekteAntwortButton = ViewBindings.findChildViewById(rootView, id);
      if (korrekteAntwortButton == null) {
        break missingId;
      }

      id = R.id.satz_text_view;
      TextView satzTextView = ViewBindings.findChildViewById(rootView, id);
      if (satzTextView == null) {
        break missingId;
      }

      return new ActivityTestWritingGermanBinding((RelativeLayout) rootView, antwortEditText,
          falscheAntwortTextView, korrekteAntwortButton, satzTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
