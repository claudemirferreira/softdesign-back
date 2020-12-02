package com.softdesign.demo.base.core.exception;

import com.softdesign.demo.base.core.dto.ErrorMessage;
import com.softdesign.demo.base.core.model.IdentifiedError;

public class BaseIdentifiedException extends RuntimeException {

    private final IdentifiedError error;

    public BaseIdentifiedException(IdentifiedError error) {
        super(error.getMessage());
        this.error = error;
    }

    public IdentifiedError getError() {
        return error;
    }

    public ErrorMessage getErrorMessageForPath(String path) {
        return ErrorMessage.ErrorMessageBuilder.anErrorMessage().fromIdentifiedError(getError()).withPath(path).build();
    }

}
