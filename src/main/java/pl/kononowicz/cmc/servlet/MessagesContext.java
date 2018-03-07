/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.kononowicz.cmc.servlet;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.SortedMap;
import java.util.TreeMap;
import org.joda.time.LocalDate;
import pl.kononowicz.cmc.entities.Message;

/**
 *
 * @author Tomasz
 */
public class MessagesContext {
    
    
    private final SortedMap<Integer, Message> messages;

    public MessagesContext() {
        messages = Collections.synchronizedSortedMap(new TreeMap<Integer, Message>());
        generateMessages(25);
    }
    
    public void generateMessages(int amount) {
        String[][] presets = {
            {"3", "Mróz", "W nocy przewidywane są przymrozki na poziomie od -26 do -30 stopni Celsjusza"},
            {"2", "Mróz", "Jutrzejsza temperatura wahać się będzie od -16 do -20 stopni Celsjusza"},
            {"1", "Mróz", "Przez kolejny tydzień przewidywana jest temperatura od -6 do -10 stopni Celsjusza"},
            {"1", "Wysoki poziom wody", "Od dnia jutrzejszego możliwe są powodzie i podtopienia spowodowane częstymi opadami deszczu"},
            {"2", "Wysoki poziom wody", "Stan pobliskich rzek przekroczy krtyczną górną granicę"},
            {"3", "Wysoki poziom wody", "Obfite opady deszczu mogą powodować zalania dróg i piwnic"},
            {"1", "Trzęsienie Ziemi", "Możliwe ruchy architektoniczne 4-5 w skali Richtera - odczuwane przez większość osób, nieszkodliwe"},
            {"2", "Trzęsienie Ziemi", "Możliwe ruchy architektoniczne 6-7 w skali Richtera - średnie i duże wstrząsy, powodują uszkodzenia budynków"},
            {"3", "Trzęsienie Ziemi", "Możliwe ruchy architektoniczne 8-9 w skali Richtera - bardzo silne wstrząsy, powodują zniszczenia miast"},
            {"1", "Silne wiatry", "Prędkość wiatru przekroczy  20 km/h. Kurz i papier podnoszą się, gałęzie zaczynają się poruszać"},
            {"2", "Silne wiatry", "Prędkość wiatru przekroczy  50 km/h. Całe drzewa w ruchu, pod wiatr idzie się z wysiłkiem"},
            {"3", "Silne wiatry", "Prędkość wiatru przekroczy  75 km/h. Lekkie konstrukcje ulegają zniszczeniu"},
            {"1", "Upał", "Temperatura powietrza na poziomie od 20 do 30 stopni Celsjusza. Weź ze sobą wodę"},
            {"2", "Upał", "Temperatura powietrza na poziomie od 30 do 40 stopni Celsjusza. Spocisz się"},
            {"3", "Upał", "Temperatura powietrza na poziomie od 40 do 50 stopni Celsjusza. Spłoniesz"},
            {"3", "Susza", "Wilgotność powietrza w dniu jutrzejszym spanie poniżej 15%"},
            {"1", "Susza", "Przez najbliższy tydzień wilgotność powietrza będzie utrzymywać się na poziomie 30%"},
            {"2", "Susza", "Przewidywane susze przez kolejne kilka dni - temperatura odczuwalna: około 30 stopni Celsjusza, wilgotność: około 25%"},
            {"3", "Rozległy pożar", "Ogromny pożar, pali się pół województwa, proszę przygotwać się do ewakuacji"},
            {"2", "Rozległy pożar", "Pożar lasu może się rozprzestrzeniać, prosimy o sprawdzanie komunikatów"},
            {"1", "Rozległy pożar", "Wypalanie łąk i pól w pobliżu gospodarstw rolnych"},
            {"3", "Obfite opady śniegu", "Sypie śniegiem, że nic nie widać, gradobicie"},
            {"2", "Obfite opady śniegu", "Jutro rano przewidywane odśnieżanie samochodu i chodnika"},
            {"1", "Obfite opady śniegu", "Lekko popruszy śniegiem a przez kolejny tydzień będzie błoto"}
        };
        String[] regions = {
            "Dolnośląskie",
            "Kujawsko-pomorskie",
            "Lubelskie",
            "Lubuskie",
            "Łódzkie",
            "Małopolskie",
            "Mazowieckie",
            "Opolskie",
            "Podkarpackie",
            "Podlaskie",
            "Pomorskie",
            "Śląskie",
            "Świętokrzyskie",
            "Warmińsko-mazurskie",
            "Wielkopolskie",
            "Zachodniopomorskie"
        };

        Random random = new Random();
        
        for (int i = 0; i<amount; i++) {
            int rand = random.nextInt(regions.length);
            Calendar cal = Calendar.getInstance();
            cal.setTime(new Date());
            cal.add(Calendar.DATE, -random.nextInt(365));
            Date date = cal.getTime();
            String region = regions[random.nextInt(regions.length)];
            Integer priority = Integer.parseInt(presets[rand][0]);
            String shortText = presets[rand][1];
            String text = presets[rand][2];                  
            messages.put(i, new Message(i, region, priority, date, shortText, text));
        }
        
    }
    
    public List<Message> getMessages() {
        return new ArrayList<>(messages.values());
    }
    
    
}
