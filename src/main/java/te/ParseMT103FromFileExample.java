package te;

import java.text.SimpleDateFormat;

import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.field.Field20;
import com.prowidesoftware.swift.model.field.Field32A;
import com.prowidesoftware.swift.model.mt.mt1xx.MT103;
import com.prowidesoftware.swift.utils.Lib;

public class ParseMT103FromFileExample {

    public static void main(String[] args) throws Exception{
        /*
         * Read and parse the file content into a SWIFT message object
         * Parse from File could also be used here
         */
        MT103 mt = MT103.parse(Lib.readResource("mt103", null));

        /*
         * Print header information
         */
        System.out.println("Sender: "+mt.getSender());
        System.out.println("Receiver: "+mt.getReceiver());

        /*
         * Print details of a specific fields
         */
        Field20 ref = mt.getField20();
        System.out.println(Field.getLabel(ref.getName(), mt.getMessageType(), null) + ": " + ref.getComponent(Field20.REFERENCE));

        Field32A f = mt.getField32A();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        System.out.println("Value Date: "+sdf.format(f.getDateAsCalendar().getTime()));
        System.out.println("Amount: "+f.getCurrency()+" "+f.getAmount());
    }
}
