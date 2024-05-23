package com.emre.publicTransport.Exception;

import com.emre.publicTransport.Core.LogManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({RouteNotFoundException.class})
    public ResponseEntity<Object> handleRouteNotFoundException(RouteNotFoundException exception) {
        LogManager.getSingleton().LogError("handleRouteNotFoundException: " + exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }
    @ExceptionHandler({StationNotFoundException.class})
    public ResponseEntity<Object> handleStationNotFoundException(StationNotFoundException exception) {
        LogManager.getSingleton().LogError("handleStationNotFoundException: " + exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }
    @ExceptionHandler({VehicleNotFoundException.class})
    public ResponseEntity<Object> handleVehicleNotFoundException(VehicleNotFoundException exception) {
        LogManager.getSingleton().LogError("handleVehicleNotFoundException: " + exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
        LogManager.getSingleton().LogError("handleRuntimeException: " + exception.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

}
