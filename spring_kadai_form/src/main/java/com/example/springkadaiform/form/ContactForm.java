package com.example.springkadaiform.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Email;
//import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ContactForm {
	 // ユーザー名
	 @NotBlank(message = "お名前を入力してください。")
    private String userName;

    // メールアドレス
	 @Email(message = "メールアドレスの入力形式が正しくありません。")
	 @NotBlank(message = "メールアドレスを入力してください。")
    private String mailAddress;

    // お問い合わせ内容	
	 @NotBlank(message = "お問い合わせ内容を入力してください。")
    private String textItem;	
}
