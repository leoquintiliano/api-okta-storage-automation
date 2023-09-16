package br.com.leadersofts.apioktastorage.auth.user.record;

import br.com.leadersofts.apioktastorage.auth.user.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
