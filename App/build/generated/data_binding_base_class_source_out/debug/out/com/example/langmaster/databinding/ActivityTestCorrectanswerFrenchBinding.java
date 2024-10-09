// Generated by view binder compiler. Do not edit!
package com.example.langmaster.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.langmaster.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityTestCorrectanswerFrenchBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final Button buttonOptionFrench2;

  @NonNull
  public final Button buttonOptionFrench3;

  @NonNull
  public final Button buttonOptionFrench4;

  @NonNull
  public final Button buttonOptionGerman1;

  @NonNull
  public final ImageView imageViewQuestionGerman;

  private ActivityTestCorrectanswerFrenchBinding(@NonNull RelativeLayout rootView,
      @NonNull Button buttonOptionFrench2, @NonNull Button buttonOptionFrench3,
      @NonNull Button buttonOptionFrench4, @NonNull Button buttonOptionGerman1,
      @NonNull ImageView imageViewQuestionGerman) {
    this.rootView = rootView;
    this.buttonOptionFrench2 = buttonOptionFrench2;
    this.buttonOptionFrench3 = buttonOptionFrench3;
    this.buttonOptionFrench4 = buttonOptionFrench4;
    this.buttonOptionGerman1 = buttonOptionGerman1;
    this.imageViewQuestionGerman = imageViewQuestionGerman;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityTestCorrectanswerFrenchBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityTestCorrectanswerFrenchBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_test_correctanswer_french, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityTestCorrectanswerFrenchBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_option_french_2;
      Button buttonOptionFrench2 = ViewBindings.findChildViewById(rootView, id);
      if (buttonOptionFrench2 == null) {
        break missingId;
      }

      id = R.id.button_option_french_3;
      Button buttonOptionFrench3 = ViewBindings.findChildViewById(rootView, id);
      if (buttonOptionFrench3 == null) {
        break missingId;
      }

      id = R.id.button_option_french_4;
      Button buttonOptionFrench4 = ViewBindings.findChildViewById(rootView, id);
      if (buttonOptionFrench4 == null) {
        break missingId;
      }

      id = R.id.button_option_german_1;
      Button buttonOptionGerman1 = ViewBindings.findChildViewById(rootView, id);
      if (buttonOptionGerman1 == null) {
        break missingId;
      }

      id = R.id.image_view_question_german;
      ImageView imageViewQuestionGerman = ViewBindings.findChildViewById(rootView, id);
      if (imageViewQuestionGerman == null) {
        break missingId;
      }

      return new ActivityTestCorrectanswerFrenchBinding((RelativeLayout) rootView,
          buttonOptionFrench2, buttonOptionFrench3, buttonOptionFrench4, buttonOptionGerman1,
          imageViewQuestionGerman);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
