package es.jlmartin.delegate;

import java.util.logging.Logger;

public class ServiceSpanish  implements Service{
    Logger LOG = Logger.getLogger(getClass().getName());
    @Override
    public void saludosEnDiferentesIdiomas() {
        LOG.info("Hola a todos gentuza");
    }
}
