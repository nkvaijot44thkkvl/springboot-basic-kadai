package com.example.springkadaiform.controller;

//import org.springframework.core.Conventions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.springkadaiform.form.ContactForm;

@Controller
public class ContactFormController {
		
    // GETリクエストでフォーム画面を表示
	@GetMapping("/form")
  
	 public String showForm(Model model) {
        model.addAttribute("contactForm", new ContactForm()); // ここで追加
        return "contactFormView";
    }

// POSTリクエストでバリデーション実施
    @PostMapping("/confirm")
    public String confirm(RedirectAttributes redirectAttributes,
            @Validated ContactForm form, BindingResult result ,Model model) {
    	System.out.println("postメソッド");
    	
    	 // バリデーションエラーがあれば、フォーム画面に戻す
        if (result.hasErrors())  {
        	System.out.println("バリデーションチェックエラー");
            // バリデーションエラーがあれば、フォーム画面に戻す
        	// フォームクラスをビューに受け渡す
            //redirectAttributes.addFlashAttribute("contactForm", form);
            // バリデーション結果をビューに受け渡す
            //redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX
            		//+ Conventions.getVariableName(form), result);
            		/*+ "contactForm",result);*/
        	
        	/*
        	 * 課題で「バリデーションNG：元のフォームへリダイレクト」と記載があるが
        	 * return "redirect:/contactFormView"の形をとると
        	 * リロードがかかり、バリデーションの結果を保持できない
        	 */
            return "contactFormView"; //Formへリダイレクト redirect:/
        }
        // バリデーションOKの場合は、確認画面に遷移
        System.out.println("バリデーションOK");
        model.addAttribute("contactForm", form);
    return "confirmView";
}
}