package com.system.pe.dto.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter 
@Setter
@NoArgsConstructor
public class AccountLoginDto {
	
	@NotBlank(message = "Ingrese un nombre de usuario.")
	@Size(max = 128, message = "Él limite de carácteres para el nombre de usuario o correo no debe sobrepasar los 128.")
	@Size(min = 5, message = "El nombre de usuario o correo necesita al menos 5 caracteres.")
    private String username;
	
    @NotBlank(message = "Ingrese una contraseña.")
    @Size(max = 128, message = "Él limite de carácteres para la contraseña no debe sobrepasar los 128.")
	@Size(min = 5, message = "La contraseña necesita al menos 5 caracteres.")
    private String password;

}
