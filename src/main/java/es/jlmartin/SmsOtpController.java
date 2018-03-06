
package es.jlmartin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;


/**@author Jose Luis Martin Rodriguez
 * @version 0.0.1
 * MVC. Capa de controlador, solo se deben de hacer llamadas a los servicios
 * COntrolador para mostrar informacion a traves de llamadas get.
 */
@RestController

public class SmsOtpController {

    Logger LOG = Logger.getLogger(getClass().getName());
    public static final int CODE = 1234;
    public static final String TEXTO = "Introduzca el codigo que se le envio por SMS";
    //http://127.0.0.1:8080/validate?code=12345
    @RequestMapping(value="/validate")//por defecto  get
    public DtoOut validateCode(@RequestParam("code") int codeV) throws Exception {
        try {
            LOG.info("Entrando a validar con codigo: "+codeV);
            return new DtoOut(codeV == CODE);
        }catch (Exception e){
            LOG.warning(e.toString());
            throw e;
        }finally {
            LOG.info("Saliendo del metodo");
        }

    }

    @RequestMapping(value="/getText")//por defecto  get
    public DtoOut getText(){
        return new DtoOut(TEXTO);
    }
}
