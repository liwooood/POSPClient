package com.cssweb.payment.posp.common;

/**
 * Created by chenhf on 2014/10/16.
 */
public class Field90 extends Field {



    public Field90()
    {
        fieldName = "原始数据元";
        fieldNo = "90";

        fieldType = FIELD_TYPE_N;

        dataLen = 42;
    }


    @Override
    public int decode(byte[] fieldData, int srcPos)
    {
        /*
        int pos = srcPos;

        byte[] varLen = new byte[3];
        System.arraycopy(fieldData, pos, varLen, 0, 3);
        dataLen = Integer.parseInt(new String(varLen));

        data = new byte[dataLen];
        System.arraycopy(fieldData, pos+3, data, 0, dataLen);

        fieldLength = 3 + dataLen;
        srcPos +=  fieldLength;


        Field121_1 field121_1 = new Field121_1();
        pos = field121_1.decode(data, field121_1.getBeginPos());
        addSubField(field121_1);

        Field121_2 field121_2 = new Field121_2();
        pos = field121_2.decode(data, field121_2.getBeginPos());
        addSubField(field121_2);

        Field121_3 field121_3 = new Field121_3();
        pos = field121_3.decode(data, field121_3.getBeginPos());
        addSubField(field121_3);

        Field121_4 field121_4 = new Field121_4();
        pos = field121_4.decode(data, field121_4.getBeginPos());
        addSubField(field121_4);

        // 读标志
        byte[] tag = new byte[2];
        System.arraycopy(data, pos, tag, 0, 2);
        String tagStr = new String(tag);

        Field121_5 field121_5 = new Field121_5();

        if (tagStr.equalsIgnoreCase("FD"))
        {
            Field121_5_FD field121_5_fd = new Field121_5_FD();
            pos = field121_5_fd.decode(data, pos);
            field121_5.addSubFieldByTag(field121_5_fd);
        }
        if (tagStr.equalsIgnoreCase("ID"))
        {
            Field121_5_ID field121_5_id = new Field121_5_ID();
            pos = field121_5_id.decode(data, pos);
            field121_5.addSubFieldByTag(field121_5_id);
        }

        addSubField(field121_5);
*/
        return srcPos;
    }

    @Override
    public void encode() throws OverflowMaxLengthException {
        dataLen = 0;

        for (Field subField : fields.values())
        {
            // System.out.println("field121_5 no=" + subField.getFieldNo());
            dataLen += subField.getFieldLength();
        }



        data = new byte[dataLen];
        for (Field subField : fields.values())
        {
            System.arraycopy(subField.getFieldValue(), 0, data, subField.getBeginPos(), subField.getFieldLength());
        }

        fieldLength = dataLen;
        fieldValue = new byte[fieldLength];



        System.arraycopy(data, 0, fieldValue, 0, dataLen);
    }
}
