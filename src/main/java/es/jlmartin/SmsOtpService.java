package es.jlmartin;

public class SmsOtpService {

    public static final String SERVICE_ID = "generateCodeSMSOtp";
    public static final String COUNTRY = "ES";
    String token;

    public SmsOtpService (String token){
        this.token = token;
    }

    public boolean generateToken(String token){
        
        boolean codeGeneratedOk = false;
        
        //En ModelBank, toda la logica se almacena en la Operacion
        //Por simplicidad, omito dicha capa.

        //Get personId by token
        PersonCommand personCommand = new PersonCommand();
        long personId = personCommand.getPersonIdWithToken(token, SERVICE_ID);
        //Get person data by personId
        Person person = personCommand.getPersonById(personId);

        //Get template by service_id and country.
        TemplateCommand templateCommand = new TemplateCommand();
        Template template = templateCommand.getTemplateByParams(SERVICE_ID, COUNTRY);

        //Generate random 4 digits string
        String codeGenerated = Utils.generateRandom4DigitsCode();

        //Get sms text formatted
        String smsText = Utils.getTemplateMessageFormatted(template.getTemplate_text(),new String[]{codeGenerated,"Amazon"});

        //Store code generate for future validation.
        StoreCodeCommand storeCodeCommand = new StoreCodeCommand();
        storeCodeCommand.storeCode(codeGenerated, SERVICE_ID, smsText, personId);

        //Call to SMS_Provider
        boolean smsSent = true;

        if(smsSent){
            //back to web component
            return true;
        } else {
            //QUE HACER? Reintentar? Mensaje de error?
            return false;
        }
    }
}
