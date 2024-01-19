package LorenzoBaldassari.Week6_Project.config;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class MailgunSender {

    private String apikey;
    private String domaine;

    public MailgunSender(@Value("${mailgun.apikey}") String apikey,
                         @Value("${mailGun.domanin}")String domaine) {
        this.apikey = apikey;
        this.domaine = domaine;
    }
    public void sendEmail(String recipient){
        HttpResponse<JsonNode> response= Unirest.post("https://api.mailgun.net/v3/" + this.domaine + "/messages")
                .basicAuth("api", this.apikey)
                .queryString("from","lorenzo baldassari <lorenzobaldassari93@gmail.com>")
                .queryString("to",recipient)
                .queryString("subject","registrazione avvenuta")
                .queryString("text","complimenti ti sei regisrato").asJson();
        System.out.println("fatto");

    }
    public void sendRegistrationEmail(String recipient) {
    HttpResponse<JsonNode> response = Unirest.post("https://api.mailgun.net/v3/" + this.domaine + "/messages")
            .basicAuth("api", this.apikey)
            .queryString("from", "lorenzo baldassari <lorenzobaldassari93@gmail.com>")
            .queryString("to", recipient)
            .queryString("subject", "Registrazione avvenuta con successo!")
            .queryString("text", "Complimenti per esserti registrato!")
            .asJson();
}
//vanno bene entrambi mancava un apice al primo!



    }

