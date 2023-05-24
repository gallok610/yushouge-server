package cn.tedu.yushougeproduct.ex;

import cn.tedu.yushougeproduct.web.ServiceCode;
import lombok.Getter;

public class ServiceException extends RuntimeException{

    @Getter
    private ServiceCode serviceCode;

    public ServiceException(ServiceCode serviceCode,String message){
        super(message);
        this.serviceCode = serviceCode;
    }
}
