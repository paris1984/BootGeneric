package es.jlmartin.delegate;

import java.util.logging.Logger;

public class ServiceItalian implements Service {
    Logger LOG = Logger.getLogger(getClass().getName());
    @Override
    public void saludosEnDiferentesIdiomas() {
        LOG.info("Ciao");
    }
}
