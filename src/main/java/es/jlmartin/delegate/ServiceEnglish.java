package es.jlmartin.delegate;

import java.util.logging.Logger;

public class ServiceEnglish implements Service {
    Logger LOG = Logger.getLogger(getClass().getName());
    @Override
    public void saludosEnDiferentesIdiomas() {
        LOG.info("Hellow everyone");
    }
}
