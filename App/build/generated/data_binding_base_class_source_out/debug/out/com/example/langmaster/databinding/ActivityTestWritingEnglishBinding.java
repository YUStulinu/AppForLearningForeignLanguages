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

public final class ActivityTestWritingEnglishBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final EditText answerEditText;

  @NonNull
  public final Button checkAnswerButton;

  @NonNull
  public final TextView incorrectAnswerTextView;

  @NonNull
  public final TextView sentenceTextView;

  private ActivityTestWritingEnglishBinding(@NonNull RelativeLayout rootView,
      @NonNull EditText answerEditText, @NonNull Button checkAnswerButton,
      @NonNull TextView incorrectAnswerTextView, @NonNull TextView sentenceTextView) {
    this.rootView = rootView;
    this.answerEditText = answerEditText;
    this.checkAnswerButton = checkAnswerButton;
    this.incorrectAnswerTextView = incorrectAnswerTextView;
    this.sentenceTextView = sentenceTextView;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTestWritingEnglishBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTestWritingEnglishBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_test_writing_english, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTestWritingEnglishBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.answer_edit_text;
      EditText answerEditText = ViewBindings.findChildViewById(rootView, id);
      if (answerEditText == null) {
        break missingId;
      }

      id = R.id.check_answer_button;
      Button checkAnswerButton = ViewBindings.findChildViewById(rootView, id);
      if (checkAnswerButton == null) {
        break missingId;
      }

      id = R.id.incorrect_answer_text_view;
      TextView incorrectAnswerTextView = ViewBindings.findChildViewById(rootView, id);
      if (incorrectAnswerTextView == null) {
        break missingId;
      }

      id = R.id.sentence_text_view;
      TextView sentenceTextView = ViewBindings.findChildViewById(rootView, id);
      if (sentenceTextView == null) {
        break missingId;
      }

      return new ActivityTestWritingEnglishBinding((RelativeLayout) rootView, answerEditText,
          checkAnswerButton, incorrectAnswerTextView, sentenceTextView);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
