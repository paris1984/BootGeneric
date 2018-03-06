package es.jlmartin;

public class Template {

    String template_text;
    String country;
    String service_id;
    int num_parameters;
    int template_id;
    double version;

    public Template(){}

    public Template(int template_id, String template_text, int num_parameters, String country,
                    String service_id, double version){
        this.template_id = template_id;
        this.template_text = template_text;
        this.num_parameters = num_parameters;
        this.country = country;
        this.service_id = service_id;
        this.version = version;
    }

    public String getTemplate_text() {
        return template_text;
    }

    public void setTemplate_text(String template_text) {
        this.template_text = template_text;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getService_id() {
        return service_id;
    }

    public void setService_id(String service_id) {
        this.service_id = service_id;
    }

    public int getNum_parameters() {
        return num_parameters;
    }

    public void setNum_parameters(int num_parameters) {
        this.num_parameters = num_parameters;
    }

    public int getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(int template_id) {
        this.template_id = template_id;
    }

    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }
}
