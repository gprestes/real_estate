package com.precious.realestate;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import static org.junit.Assert.assertTrue;

public class TestPhantomJSDriver {

    public static void main(String[] argv) {

        String state = "RS";
        String city = "Porto_Alegre";
        //TODO: Create method to convert neighbourhood list to a String
        String neighbourhood = "1%C2%BA_Centen%C3%A1rio-Aberta_Dos_Morros-Agronomia-Alphaville-Alto_Petr%C3%B3polis-Alto_Teres%C3%B3polis-Altos_Do_Ip%C3%AA-Altos_Do_Santa_Rita-Anchieta-Aparecida-Arroio_Do_Silva-Auxiliadora-Azenha-Bar%C3%A3o_Do_Ca%C3%AD-Bela_Vista-Bel%C3%A9m_Novo-Bel%C3%A9m_Velho-Boa_Vista-Bom_Fim-Bom_Jesus-Camaqu%C3%A3-Cascata-Cavalhada-Cedro-Cefer-Central-Centro-Centro_Hist%C3%B3rico-Chap%C3%A9u_Do_Sol-Ch%C3%A1cara_Das_Pedras-Cidade_Baixa-Coronel_Apar%C3%ADcio_Borges-Costa_E_Silva-Cristal-Cristo_Redentor-ECOVILLE_LESTE-Ecoville-Esp%C3%ADrito_Santo-Farrapos-Farroupilha-Floresta-Gl%C3%B3ria-Guaruj%C3%A1-Gua%C3%ADba-Higien%C3%B3polis-Humait%C3%A1-H%C3%ADpica-Ilha_Da_Pintada-Ilha_Grande_Dos_Marinheiros-Ilhas_Das_Flores-Imperial_Park-Independ%C3%AAncia-Intercap-Ipanema-Ipiranga-Itapema-Jardim-Jardim_Am%C3%A9rica-Jardim_Bot%C3%A2nico-Jardim_Das_Am%C3%A9ricas-Jardim_Do_Salso-Jardim_Do_Sol-Jardim_Europa-Jardim_Floresta-Jardim_Ing%C3%A1-Jardim_Ipiranga-Jardim_Ipu-Jardim_Isabel-Jardim_Itati-Jardim_It%C3%A1lia-Jardim_It%C3%BA_Sabar%C3%A1-Jardim_Leopoldina-Jardim_Lindoia-Jardim_Planalto-Jardim_Sao_Pedro-Jardim_Verde-Jardim_Vila_Nova-Lajeadinho-Lajeado_Grande-Lami-Liberdade-Lind%C3%B3ia-Lomba_Do_Pinheiro-Mario_Quintana-Mato_Grande-Medianeira-Menino_Deus-Minuano-Moinhos-Moinhos_De_Vento-Mont_Serrat-Morro_Santa_Tereza-Morro_Santana-Navegantes-Nova_Ipanema-O%C3%A1sis_Sul-Parque_Amador-Parque_Dos_Maias-Parque_Minuano-Parque_Santa_Anita-Parque_Santa_F%C3%A9-Partenon-Pasqualini-Passo_Das_Pedras-Passo_Do_Feij%C3%B3-Pedra_Redonda-Petr%C3%B3polis-Planalto-Ponta_Grossa-Porto_Alegre-Praia_De_Belas-Prot%C3%A1sio_Alves-Restinga-Restinga_Nova-Rio_Branco-Rubem_Berta-Santa_Anita-Santa_Cecilia-Santa_F%C3%A9-Santa_Helena-Santa_Isabel-Santa_Maria_Goretti-Santa_Tereza-Santana-Santo_Ant%C3%B4nio-Sarandi-Serraria-Stela_Maris-S%C3%A3o_Caetano-S%C3%A3o_Geraldo-S%C3%A3o_Jos%C3%A9-S%C3%A3o_Jo%C3%A3o-S%C3%A3o_Luiz-S%C3%A3o_Pedro-S%C3%A3o_Sebasti%C3%A3o-S%C3%A9timo_C%C3%A9u-Terra_Ville-Timbauva-Tramandai_Sul-Tr%C3%AAs_Figueiras-Urubatan-Viam%C3%A3o-Vila_Assun%C3%A7%C3%A3o-Vila_Conceicao-Vila_Ipiranga-Vila_Jardim-Vila_Jo%C3%A3o_Pessoa-Vila_Nova-Vila_Oper%C3%A1ria-Vila_Petr%C3%B3polis-%C3%81guas_Claras";
        //TODO: Convert types to something meaningful and use method to concatenate them in a String
        String type = "100-29-95-50-109-18-106";
        String bedroomCount = "1";
        String parkingCount = "1";
        String minValue = "200000";
        String maxValue = "300000";
        String pageNumber = "1";
        String resultsPerPage = "10";
        //TODO: Explore other options (Maybe split field/sort order)
        String sortBy = "ValueDesc";


        String url = "http://www.auxiliadorapredial.com.br/Vendas/busca/" +
                state + "/" +
                city + "/" +
                neighbourhood + "/" +
                type + "/" +
                "m=" + bedroomCount + "/" +
                "m=" + parkingCount + "/" +
                minValue + "/" +
                maxValue + "/" +
                "Page" + pageNumber + "/" +
                resultsPerPage + "/" +
                sortBy + "/";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("takesScreenshot", true);

        WebDriver driver = new PhantomJSDriver(caps);

        driver.get(url);

        WebElement element = driver.findElement(By.name("q"));

        String strToSearchFor = "Cheese!";
        element.sendKeys(strToSearchFor);

        element.submit();

        assertTrue(driver.getTitle().toLowerCase().contains(strToSearchFor.toLowerCase()));

        driver.quit();
    }
}