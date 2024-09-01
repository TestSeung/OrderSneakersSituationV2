package OrderSneakersSituationV2;

import Qustion.W4Day6.CustomerLevel;
import Qustion.W4Day6.Staff;

import java.util.Scanner;

public class OrderSneakersSituationV2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        final long TODAY_START_SALES_AMOUNT = 0;

        Staff staff = new Staff(TODAY_START_SALES_AMOUNT);

        staff.readFileAndSetSneakerInfoMap();
        staff.readFileAndSetSneakersStockMap();


        // 고객 대기 등록을 받습니다.
        System.out.println("안녕하세요~, \"고객등급,이름,배송선호 여부,예산,운동화 모델명\" 입력해주세요");

        while (scanner.hasNext()) {
            String response = scanner.nextLine();

            if (response.equals("끝")) {
                break;
            }

            try {
                String[] responseArray = response.split(",");
                CustomerLevel customerLevel = CustomerLevel.valueOf(responseArray[0]);
                String customerName = responseArray[1];
                boolean isCustomerLikeDelivery = Boolean.parseBoolean(responseArray[2]);
                Long cache = Long.parseLong(responseArray[3]);

                /**
                 * 고객 대기 목록 명단에 고객 객체 넣어야합니다.
                 */

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("입력 형식이 잘못 되어 고객 등록 넘어갑니다.");
            }
        }
        /**
         * 이후 작업 이어서 진행 해주세요.
         */

    }
}
