package es.jlmartin;

public class TemplateCommand {

    /**
     * Método que recupera el template asociado a un servicio
     * y un país.
     * @param service_id
     * @param country
     * @return
     */
    public Template getTemplateByParams(String service_id, String country){

        //Aqui se obtendría el template de nuestra BBDD.
        //Se recupera la mayor version del template.
        return new Template(1,"ING SMS code {0} para {1}",2, country, service_id, 1);

    }

    /**
     * Método que recupera el template asociado a un servicio
     * y un país con una version específica.
     * @param service_id
     * @param country
     * @param version
     * @return
     */
    public Template getTemplateByVersion(String service_id, String country, double version){
        return new Template(2,"ING SMS code {0} para {1} v2",2, country, service_id, 2);
    }
}
