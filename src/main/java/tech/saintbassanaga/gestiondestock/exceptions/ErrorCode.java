package tech.saintbassanaga.gestiondestock.exceptions;


import lombok.Getter;
import org.springframework.web.client.HttpStatusCodeException;

@Getter
public enum ErrorCode {

    ARTICLE_NOT_FOUND(1000),
    ARTICLE_NOT_VALID(1001),
    CATEGORY_NOT_FOUND(2000),
    CATEGORY_NOT_VALID(2001),
    CLIENT_NOT_FOUND(3000),
    CLIENT_NOT_VALID(3001),
    COMMAND_CLIENT_NOT_FOUND(4000),
    COMMAND_PROVIDER_NOT_FOUND(5000),
    ENTERPRISE_NOT_FOUND(6000),
    PROVIDER_NOT_FOUND(8000),
    COMMAND_CLIENT_LINE_NOT_FOUND(9000),
    COMMAND_PROVIDER_LINE_NOT_FOUND(10000),
    MOVEMENT_STOCK_NOT_FOUND(11000),
    USER_NOT_FOUND(12000),
    SALE_NOT_FOUND(13000)
    ;

    private final int code;

    ErrorCode(int code){
        this.code =code;
    }

}
