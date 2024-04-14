package com.santanu.TastyTracks.service;

import com.santanu.TastyTracks.model.PasswordResetToken;

public interface PasswordResetTokenService {

    public PasswordResetToken findByToken(String token);

    public void delete(PasswordResetToken resetToken);

}
