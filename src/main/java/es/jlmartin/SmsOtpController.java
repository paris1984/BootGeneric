
package es.jlmartin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
    private static final Integer MAXINTENTS = 3;

    HashMap<Integer,Integer> intentos = new HashMap<Integer, Integer>();
    //http://127.0.0.1:8080/validate?code=12345&session=1
    @RequestMapping(value="/validate")//por defecto  get
    public DtoOut validateCode(@RequestParam("code") int codeV,@RequestParam("session") int session) throws Exception {
        try {
            LOG.info("Entrando a validar con codigo: "+codeV+" de la sesion: "+session);
            String message = "";
            boolean valid = codeV == CODE;
            Integer intents = intentos.get(session);
            if(intents !=null){
                if(intents<MAXINTENTS){
                    if(valid){
                        return new DtoOut("Codigo correcto",valid,intents);
                    }else{
                        intentos.remove(session);
                        intents++;
                        intentos.put(session,intents);
                        return new DtoOut("Codigo incorrecto",valid,intents);
                    }
                }else{
                    return new DtoOut("Numero de intentos superado",valid,intents);
                }
            }else{
                if(valid){
                    return new DtoOut("Codigo correcto",valid,1);
                }else{

                    intentos.put(session,1);
                    return new DtoOut("Codigo incorrecto",valid,1);
                }
            }

        }catch (Exception e){
            LOG.warning(e.toString());
            throw e;
        }finally {
            LOG.info("Saliendo del metodo");
        }

    }

}
