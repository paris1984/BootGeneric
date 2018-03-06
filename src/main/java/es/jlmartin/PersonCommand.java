package es.jlmartin;

public class PersonCommand {

    public static final int PERSON_ID = 00001111;

    /**
     * Método que recupera el personId de base de datos
     * mediante el token asociado
     *
     * @param token Unique token that identifies a user
     * @param serviceId Service required
     * @return int personId
     */
    public long getPersonIdWithToken(String token, String serviceId){
        return PERSON_ID;
    }

    /**
     * Método que recupera informacion útil para el envío
     * del sms relacionada al personId
     *
     * @param personId
     * @return
     */
    public Person getPersonById(long personId) {
        return new Person(personId,"691350485","ES");
    }
}
