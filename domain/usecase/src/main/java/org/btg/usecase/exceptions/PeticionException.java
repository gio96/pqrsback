package org.btg.usecase.exceptions;

public class PeticionException extends RuntimeException {
    public enum Type {
        PETICION_NOT_FOUND("La peticion no existe", 404),
        PETICION_NOT_UPDATE("La peticion no se puede actualizar", 412),
        PETICION_NOT_FULL("La peticion fue mal formada", 500);

        private final String message;
        private final Integer status;

        public PeticionException build() {
            return new PeticionException(this);
        }

        Type(String message, Integer status) {
            this.message = message;
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public Integer getStatus() {
            return status;
        }
    }

    private final PeticionException.Type type;

    private PeticionException(PeticionException.Type type) {
        super(type.message);
        this.type = type;
    }

    public PeticionException.Type getType() {
        return type;
    }
}
