
package es.jlmartin;

import es.jlmartin.delegate.Delegate;
import es.jlmartin.delegate.Service;
import es.jlmartin.delegate.Tipos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.logging.Logger;


/**@author Jose Luis Martin Rodriguez
 * @version 0.0.1
 * MVC. Capa de controlador, solo se deben de hacer llamadas a los servicios
 * COntrolador para mostrar informacion a traves de llamadas get.
 */
@RestController

public class SmsOtpController {

    Logger LOG = Logger.getLogger(getClass().getName());
    public static int CODE = 1234;
    public static final String TEXTO = "Introduzca el codigo que se le envio por SMS";
    private static final Integer MAXATTEMPTS = 3;

    @Autowired
    @Qualifier("delegate")
    Delegate<Tipos,Service> delegate;

    HashMap<Integer,Integer> intentos = new HashMap<Integer, Integer>();
    //http://127.0.0.1:8080/validate?code=12345&session=1
    @RequestMapping(value="/validate")//por defecto  get
    public DtoOut validateCode(@RequestParam("code") int codeV,@RequestParam("session") int session) throws Exception {
        try {

            delegate.getDelegate(Tipos.DOS).saludosEnDiferentesIdiomas();

            LOG.info("Entrando a validar con codigo: "+codeV+" de la sesion: "+session);
            String message = "";
            boolean valid = codeV == CODE;
            Integer intents = intentos.get(session);
            if(intents !=null){
                if(intents< MAXATTEMPTS){
                    if(valid){
                        return new DtoOut("Codigo correcto",valid,intents, MAXATTEMPTS);
                    }else{
                        intentos.remove(session);
                        intents++;
                        intentos.put(session,intents);
                        return new DtoOut("Codigo incorrecto",valid,intents, MAXATTEMPTS);
                    }
                }else{
                    return new DtoOut("Numero de intentos superado",valid,intents, MAXATTEMPTS);
                }
            }else{
                if(valid){
                    return new DtoOut("Codigo correcto",valid,1, MAXATTEMPTS);
                }else{

                    intentos.put(session,1);
                    return new DtoOut("Codigo incorrecto",valid,1, MAXATTEMPTS);
                }
            }

        }catch (Exception e){
            LOG.warning(e.toString());
            throw e;
        }finally {
            LOG.info("Saliendo del metodo");
        }

    }

    @RequestMapping("/generatecode")
    String generateCode(){
        CODE++;
        return "{\"result\" : \"true\"}";
}

    @RequestMapping("/getcode")
    String getCode(){
        return String.valueOf(CODE);
    }

}
