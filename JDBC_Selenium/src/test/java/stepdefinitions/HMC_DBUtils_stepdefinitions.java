package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import utilities.DBUtils;

import java.sql.SQLException;

public class HMC_DBUtils_stepdefinitions {
    @Given("kullanici DBUtils ile HMC veri tabanina baglanir")
    public void kullaniciDBUtilsIleHMCVeriTabaninaBaglanir() {
        DBUtils.getConnection();
    }

    @And("kullanici DBUtils ile {string} tablosundaki {string} verilerini alir")
    public void kullaniciDBUtilsIleTablosundakiVerileriniAlir(String table, String field) {
        String query = "SELECT "+field+" FROM "+ table; // Sorguya ne yazarsak o çalışır
        DBUtils.executeQuery(query);
    }

    @And("kullanici DBUtils ile {string} sutunundaki verileri okur")
    public void kullaniciDBUtilsIleSutunundakiVerileriOkur(String field) throws SQLException {
        DBUtils.getResultset().first();
            System.out.println(DBUtils.getResultset().getString(field));
    }

    @And("DBUtil ile tum {string} degerlerini sira numarasi ile yazdirir")
    public void dbutilIleTumDegerleriniSiraNumarasiIleYazdirir(String field) throws SQLException {
        DBUtils.getResultset().last();
        int sonSatirNo=DBUtils.getResultset().getRow();
        DBUtils.getResultset().first();
        for (int i = 1; i < sonSatirNo; i++) {
            System.out.println(i+ ". kayıt :"+DBUtils.getResultset().getString(field));
        DBUtils.getResultset().next();
        }
    }

    @Then("DBUtils ile {int}. {string} in {int} oldugunu test eder")
    public void dbutilsIleInOldugunuTestEder(int istenenSiraNo, String field, int expectedDeger) throws SQLException {
    DBUtils.getResultset().absolute(istenenSiraNo);
    double actualDeger=DBUtils.getResultset().getDouble(field);

        Assert.assertTrue(actualDeger==expectedDeger);
    }

    @Then("tHOTEL tablosunda IDHotel degeri {int} olan kaydin Email bilgisini {string} yapar")
    public void thotelTablosundaIDHotelDegeriOlanKaydinEmailBilgisiniYapar(int idHotel, String yeniEmail) {
    String updateQuery="UPDATE tHOTEL SET Email='"+yeniEmail+"' WHERE IDHotel="+idHotel+";";
    DBUtils.executeQuery(updateQuery);
    }
}
