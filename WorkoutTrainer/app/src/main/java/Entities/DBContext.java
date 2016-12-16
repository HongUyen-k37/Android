package Entities;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import vn.husc.it.bb.workouttrainer.R;

/**
 * Created by Admin on 12/14/2016.
 */

public class DBContext extends SQLiteOpenHelper {
    public static final String DB_Name = "WORKOUTTRAINER.DB";
    private static final int DB_Version = 1;
    public DBContext(Context context) {
        super(context, DB_Name, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Tạo table
        db.execSQL("CREATE TABLE Category (\n" +
                "    ID_Category INTEGER      PRIMARY KEY\n" +
                "                             NOT NULL,\n" +
                "    Name        VARCHAR (50) NOT NULL\n" +
                "                             UNIQUE\n" +
                ");\n");
        db.execSQL("CREATE TABLE Exercise (\n" +
                "    ID_Exercise INTEGER      PRIMARY KEY\n" +
                "                             NOT NULL,\n" +
                "    Name        VARCHAR (50) UNIQUE\n" +
                "                             NOT NULL,\n" +
                "    Note        TEXT         UNIQUE,\n" +
                "    Image       VARCHAR (50),\n" +
                "    Time        INTEGER,\n" +
                "    Option      INTEGER,\n" +
                "    ID_Category INTEGER      NOT NULL\n" +
                "                             REFERENCES Category (ID_Category) ON DELETE CASCADE\n" +
                "                                                               ON UPDATE CASCADE\n" +
                ");\n");
        //Nhập dữ liệu
        db.execSQL("INSERT INTO Category (\n" +
                "                         Name,\n" +
                "                         ID_Category\n" +
                "                     )\n" +
                "                     VALUES (\n" +
                "                         'Legs',\n" +
                "                         1\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'Lats',\n" +
                "                         2\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'Chest',\n" +
                "                         3\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'Shoulder',\n" +
                "                         4\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'Biceps',\n" +
                "                         5\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'Triceps',\n" +
                "                         6\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'Abs',\n" +
                "                         7\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'Cardio',\n" +
                "                         8\n" +
                "                     );\n");
        db.execSQL("INSERT INTO Exercise (\n" +
                "                         ID_Category,\n" +
                "                         Option,\n" +
                "                         Time,\n" +
                "                         Image,\n" +
                "                         Note,\n" +
                "                         Name,\n" +
                "                         ID_Exercise\n" +
                "                     )\n" +
                "                     VALUES (\n" +
                "                         1,\n" +
                "                         NULL,\n" +
                "                         NULL,\n" +
                "                         "+R.drawable.exe_1+",\n" +
                "                         'Bắt đầu với chân rộng ngang vai, tay bên hông.\nBước tới trước, co đầu gối để hạ hông xuống. Hạ cho tới khi đầu gối sau gần chạm mặt đất. Thân thẳng, đầu gối trước trên bàn chân trước.\nĐẩy gót chân trên, duỗi hai chân để đưa thân đứng lên.\nLặp lại tư thế tấn trước với chân kia.\nLặp lại cho tới khi đạt được số lần yêu cầu.',\n" +
                "                         'Walking Lunge with Side Weight',\n" +
                "                         1\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         1,\n" +
                "                         NULL,\n" +
                "                         NULL,\n" +
                "                         "+R.drawable.exe_2+",\n" +
                "                         'Bắt đầu bằng đặt thanh tạ ở trên giá tạ ở mức ngay phía dưới vai.\nGiữ thanh tạ bằng hai tay, hai bên và nâng thanh tạ ra khỏi giá bằng cách đẩy chân và cùng một lúc nắn thẳng thân mình.\nTừ từ hạ thanh tạ xuống bằng cách cong đầu gối và hông, trong khi vẫn thân thẳng và đầu hướng lên. Tiếp tục hạ xuống cho đến khi đùi và cẳng chân tạo một góc ít hơn 90 độ 1 chút. Hít thở vào trong giai đoạn này.\nBắt đầu nâng thanh tạ lên, trong khi thở ra, bằng cách đẩy gót chân lên sàn và thẳng chân lên trở lại vị trí bắt đầu.\nLặp lại cho đến khi đạt được số hiệp cần thiết.',\n" +
                "                         'Barbell Squat',\n" +
                "                         2\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         2,\n" +
                "                         NULL,\n" +
                "                         NULL,\n" +
                "                         "+R.drawable.exe_3+",\n" +
                "                         'Nắm chắc thanh xà, đưa lưng của bạn nghiêng ra trước khoảng 30 độ, cố định độ cong của lưng dưới và giữ chắc cơ ngực để cố định vai. Đây là vị trí bắt đầu bài tập.\nKéo thân người của bạn lên cho đến khi cằm vượt qua thanh xà hoặc thanh xà chạm vào ngực. Thở ra.\nTừ từ hạ người xuống, hít vào trong suốt quá trình.',\n" +
                "                         'Bodyweight Pull Up',\n" +
                "                         3\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         2,\n" +
                "                         NULL,\n" +
                "                         NULL,\n" +
                "                         "+R.drawable.exe_4+",\n" +
                "                         'Khuyến khích cách sử dụng tay cầm thuận và rộng hơn vai.\nĐưa cùi trỏ về phía sau sẽ hạn chế được sự tham gia của tay trước và ngực, tập trung nhiều hơn vào cơ xô.\nHạ người chậm có điều khiển. Tập trung vào lượt hạ người.\nXuống chậm hít vào trong suốt quá trình.\nĐưa người lên thì thở ra.',\n" +
                "                         'Cable Lat Pulldown',\n" +
                "                         4\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         3,\n" +
                "                         2,\n" +
                "                         90,\n" +
                "                         "+R.drawable.exe_5+",\n" +
                "                         'Mỗi tay giữ 1 tạ đơn, đặt trên đỉnh của 2 đùi. Hai lòng bàn tay hướng vào nhau.\nSau đó nâng tạ lên , xoay 2 cổ tay về phía trước sao cho 2 lòng bàn tay đưa về phía trước.\nHai tạ ở 2 bên ngực, tay trên và cẳng tay tạo thành 1 góc 90 độ. Đây là vị trí ban đầu.\nKhi thở ra, dùng lực cơ ngực để đẩy tạ đơn lên, căng cứng ngực, giữu trong vài giây, hít vào và từ từ hạ xuống. Lặp lại.',\n" +
                "                         'Dumbell Bench Press',\n" +
                "                         5\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         3,\n" +
                "                         2,\n" +
                "                         90,\n" +
                "                         "+R.drawable.exe_6+",\n" +
                "                         'Hai tay giữ thanh tạ, rộng bằng vai, lòng bàn tay hướng ra khỏi thân người.\nNhấc tạ khỏi khung xà, giữ tạ ngay trên ngực, hai tay hơi duỗi thẳng. Đây là vị trí ban đầu. Hít vào, hạ thanh tạ đòn xuống xương ức bằng các gập hai cùi chỏ lại. Giữ yên trong vài giây và không được nhấc tạ khỏi ngực. Cơ lưng xô giữ cố định và hai cùi chỏ hơi kéo vào trong.\nSau khi thanh xà chạm thân người, thở ra, duỗi hai để đẩy tạ về vị trí ban đầu.',\n" +
                "                         'Incline Bench Press',\n" +
                "                         6\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         4,\n" +
                "                         NULL,\n" +
                "                         NULL,\n" +
                "                         "+R.drawable.exe_7+",\n" +
                "                         'Giữ thanh đòn ngang vai với lòng bàn tay hướng tới trước. Chân thẳng mở rộng ra, gối hơi cong. Nhấc tạ lên qua đầu và giữ chắc cánh tay của bạn.\nHít vào và hạ tạ xuống ngang vai.\nThở ra và đẩy tạ lên vị trí ban đầu.',\n" +
                "                         'Barbell Shoulder Press',\n" +
                "                         7\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         4,\n" +
                "                         NULL,\n" +
                "                         NULL,\n" +
                "                         "+R.drawable.exe_8+",\n" +
                "                         'Đặt tạ đôi dựng đứng trên đùi. Nâng tạ lên ngang vai, từng cái một.\nXoay cổ tay để lòng bàn tay hướng về phía trước.\nThở ra và đẩy tạ lên phía trên cùng.\nSau khi ngưng lại một chút ở vị trí trên cùng, từ từ hạ tạ xuống vị trí bắt đầu trong khi hít vào.\nLặp lại cho tới khi đạt được số lần yêu cầu.',\n" +
                "                         'Dumbell Shoulder Press',\n" +
                "                         8\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         5,\n" +
                "                         NULL,\n" +
                "                         NULL,\n" +
                "                         "+R.drawable.exe_9+",\n" +
                "                         'Đứng thẳng, 2 tay cầm tạ, 2 chân rộng bằng vai. Khuỷu tay cố định sát người, lòng bàn tay cầm tạ hướng vào thân người. Giữ cố định phần cánh tay phía trên, cuốn 2 bên tạ lên phía trên đồng thời xoay cẳng tay cho cổ tay ngửa lên trên.\nTiếp tục đưa tạ lên vị trí cao nhất là ngang vai và thở ra. Giữ vị trí tạ ngang vai 1 nhịp.Từ từ hạ tạ xuống vị trí ban đầu và hít vào trong suốt quá trình hạ tạ (Nhớ để tạ xoay về vị trí ban đầu).\nLặp lại chuyển động với tay bên kia.',\n" +
                "                         'Dumbell Biceps Curl',\n" +
                "                         9\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         5,\n" +
                "                         1,\n" +
                "                         90,\n" +
                "                         "+R.drawable.exe_10+",\n" +
                "                         'Tay cầm với độ rộng của vai (bằng hoặc rộng hơn vai 1 chút).\nĐặt thanh tạ sát người, tay thẳng. Hít vào lấy hơi. Đây là vị trí bắt đầu bài tập.\nCuốn tay trước đưa thanh tạ lên trên và thở ra.\nTừ tự hạ thanh tạ xuống. Hít vào khi hạ tạ.',\n" +
                "                         'EZ-Baz Biceps Curl 1',\n" +
                "                         10\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         5,\n" +
                "                         1,\n" +
                "                         60,\n" +
                "                         "+R.drawable.exe_11+",\n" +
                "                         'Cánh tay thẳng nhưng vẫn phải đảm bảo cơ tay trước được căng. Cánh tay vuông góc với cơ thể. Hít 1 nhịp. Đây là vị trí bắt đầu bài tập.\nDùng cơ tay trước co lại, kéo cẳng tay lên phía trên, đảm bảo 2 tay lên đều nhau giúp thanh tạ được thăng bằng. Thở ra. Đảm bảo cẳng tay không lên quá cao, trùng cơ tay trước. Mất lực căng tác động lên cơ tay trước.\nTừ từ hạ tạ trở lại vị trí bắt đầu đồng thời hít vào trong suốt quá trình hạ tạ.\nLặp lại chuyển động với những reps sau.',\n" +
                "                         'EZ-Bar Biceps Curl 2',\n" +
                "                         11\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         6,\n" +
                "                         1,\n" +
                "                         90,\n" +
                "                         "+R.drawable.exe_12+",\n" +
                "                         'Đứng thẳng, lưng thẳng, chân mở rộng bằng vai. Đứng gần sát với tay cầm dây cáp, cánh tay song song với sàn.\nThở ra, sử dụng cơ tam đầu kéo dây cáp xuống tới trước 2 đùi, chú ý chỉ có cẳng tay di chuyển, cánh tay vẫn giữ sát thân người cố định, cánh tay mở rộng khi xuống vị trí thấp nhất và gần vuông góc với sàn.\nHít vào và từ từ đưa tay về vị trí ban đầu.',\n" +
                "                         'Cable Triceps Pushdown',\n" +
                "                         12\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         6,\n" +
                "                         NULL,\n" +
                "                         NULL,\n" +
                "                         "+R.drawable.exe_13+",\n" +
                "                         'Giữ bắp tay gần đầu, vuông góc với mặt đất, hạ tạ vòng cung phía sau đầu cho đến khi cẳng tay chạm cơ nhị đầu. Bắp tay luôn tĩnh, chỉ có cẳng tay chuyển động. Thở vào trong khi làm động tác này.\nQuay trở lại vị trí bắt đầu bằng cách dùng cơ tam đầu nâng tạ. Thở ra trong khi thực hiện.\nLặp lại cho đến khi đạt được số lần yêu cầu.',\n" +
                "                         'Dumbell Triceps Extension',\n" +
                "                         13\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         7,\n" +
                "                         3,\n" +
                "                         90,\n" +
                "                         "+R.drawable.exe_14+",\n" +
                "                         'Đưa chân lên để đùi vuông góc với mặt đất và bàn chân sát vào nhau, song song với mặt đất. Đây là vị trí bắt đầu.\nTrong khi hít vào, đưa chân về phía thân hình trong khi cuốn xương chậu và nhấc hông ra khỏi mặt đất. Ở cuối chuyển động này đầu gối chạm ngực.\nGiữ ở vị trí co trong một giây và chuyển chân về vị trí bắt đầu trong khi thở ra.\nLặp lại động tác cho tới khi đạt được số lần yêu cầu.',\n" +
                "                         'Lying Reverse Crunch Up',\n" +
                "                         14\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         7,\n" +
                "                         3,\n" +
                "                         90,\n" +
                "                         "+R.drawable.exe_15+",\n" +
                "                         'Qùy bên dưới máy kéo, 2 tay giữ 2 đầu sợi dây và giữ 2 bên co, lưng thẳng và hơi nghiêng người xuống. Cố định tay bên hông co.\nThở ra, kết hợp căng cơ bụng và thắt lưng cúi người xuống đến khi cùi chỏ chạm 2 đùi. Giữ 1 giây.\nHít vào và trở về vị trí ban đầu.',\n" +
                "                         'Kneeling Cable Crunch',\n" +
                "                         15\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         7,\n" +
                "                         3,\n" +
                "                         90,\n" +
                "                         "+R.drawable.exe_16+",\n" +
                "                         'Nằm sấp, chống hai khuỷu tay vuông góc ngay dưới vai.\nNhón hai mũi chân lên, và nâng người lên giữ lưng, hông và đầu thẳng hàng, bạn chỉ việc giữ im tư thế như thế ít nhất là 30 giây, cố gắng siết chặt cơ bụng của bạn và thở đều.',\n" +
                "                         'Plank',\n" +
                "                         16\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         7,\n" +
                "                         3,\n" +
                "                         120,\n" +
                "                         "+R.drawable.exe_17+",\n" +
                "                         'Nằm ngửa trên sàn, hai tay để dưới mông, chân co tự nhiên.\nBắt đầu nâng 2 chân lên cao, duỗi thẳng, căng cơ bụng.\nBắt đầu đưa 1 chân lên trên chân kia, sau đó hạ xuống và đổi chân còn lại lên cao.\nThực hiện luân phiên 2 chân trong 20-25 lần.',\n" +
                "                         'Lying scissor kicks',\n" +
                "                         17\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         8,\n" +
                "                         4,\n" +
                "                         1800,\n" +
                "                         "+R.drawable.exe_18+",\n" +
                "                         NULL,\n" +
                "                         'Running',\n" +
                "                         18\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         8,\n" +
                "                         4,\n" +
                "                         600,\n" +
                "                         "+R.drawable.exe_19+",\n" +
                "                         NULL,\n" +
                "                         'Step Machine',\n" +
                "                         19\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         8,\n" +
                "                         4,\n" +
                "                         1800,\n" +
                "                         "+R.drawable.exe_20+",\n" +
                "                         NULL,\n" +
                "                         'Bicycle Machine',\n" +
                "                         20\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         8,\n" +
                "                         4,\n" +
                "                         600,\n" +
                "                         "+R.drawable.exe_21+",\n" +
                "                         NULL,\n" +
                "                         'Eliptical Machine',\n" +
                "                         21\n" +
                "                     );\n");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
