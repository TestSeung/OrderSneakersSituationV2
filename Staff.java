package OrderSneakersSituationV2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Staff {
    private Map<String, SneakersInfo> sneakersInfoMap;
    private Map<String, Long> sneakersStockMap;

    private List<SaleInfo> saleInfoList;
    private long salesAmount;

    public Staff(long salesAmount) {
        this.sneakersInfoMap = new HashMap<>();
        this.sneakersStockMap = new HashMap<>();
        this.saleInfoList = new ArrayList<>();
        this.salesAmount = salesAmount;
    }

    public void readFileAndSetSneakerInfoMap(){
        try(BufferedReader fis = new BufferedReader(new FileReader("src/project/week2/inputs/nike-sneaker-characters.txt"))){

            String line;
            while(true){
                line = fis.readLine();
                if(line == null) break;

                String[] strArray = line.split("\\|");
                String modelName = strArray[0];
                long price = Long.parseLong(strArray[1]);
                String[] features = strArray[2].split(",");

                SneakersInfo sneakersInfo = new SneakersInfo(modelName, price, features);
                sneakersInfoMap.put(modelName, sneakersInfo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("직원: 운동화 정보 다음과 같이 숙지하였습니다. " + this.sneakersInfoMap);
    }

    public void readFileAndSetSneakersStockMap() {
        try(BufferedReader fis = new BufferedReader(new FileReader("src/project/week2/inputs/nike-sneaker-stocks.txt"))){

            String line;
            while(true){
                line = fis.readLine();
                if(line == null) break;

                String[] strArray = line.split("\\|");
                String modelName = strArray[0];
                long stock = Long.parseLong(strArray[1]);

                sneakersStockMap.put(modelName, stock);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("직원: 운동화 재고 정보 다음과 같이 숙지하였습니다. " + this.sneakersStockMap);
    }

}
