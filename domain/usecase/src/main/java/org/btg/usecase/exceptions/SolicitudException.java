package org.btg.usecase.exceptions;

public class SolicitudException extends RuntimeException {
    public enum Type {
        PETICION_NOT_FOUND("La Solicitud no existe", 404),
        PETICION_NOT_UPDATE("La Solicitud no se puede actualizar", 412),
        SOLICITUD_NOT_FULL("La Solicitud fue mal formada", 500);

        private final String message;
        private final Integer status;

        public SolicitudException build() {
            return new SolicitudException(this);
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

    private final SolicitudException.Type type;

    private SolicitudException(SolicitudException.Type type) {
        super(type.message);
        this.type = type;
    }

    public SolicitudException.Type getType() {
        return type;
    }
}
