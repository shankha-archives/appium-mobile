package com.frontline.config;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MatrixResult implements Iterable<MatrixResult.MatrixValue> {
    private String[] columnNames;

    private List<String[]> elementArray;

    private Map<String, Integer> columnMap = new HashMap<>(10);

    private Log log = LogFactory.getLog(MatrixResult.class);

    public class MatrixValue {
        private MatrixResult mR;

        private int index;

        public MatrixValue(MatrixResult mR, int index) {
            this.mR = mR;
            this.index = index;
        }

        public String getValue(String columnName) {
            return this.mR.getValue(this.index, columnName);
        }

        public String[] getValues() {
            return this.mR.getRecord(this.index);
        }
    }

    public MatrixResult(String[] columnNames, List<String[]> elementArray) {
        this.columnNames = columnNames;
        this.elementArray = elementArray;
        for (int i = 0; i < columnNames.length; i++)
            this.columnMap.put(columnNames[i].toLowerCase(), Integer.valueOf(i));
    }

    public String[] getRecord(int recordNumber) {
        return this.elementArray.get(recordNumber);
    }

    public String[] getFieldNames() {
        return this.columnNames;
    }

    public String getValue(int recordNumber, String columnName) {
        String[] currentRecord = getRecord(recordNumber);
        int columnNumber = ((Integer)this.columnMap.get(columnName.toLowerCase())).intValue();
        if (columnNumber >= currentRecord.length)
            return null;
        return currentRecord[columnNumber];
    }

    public int getSize() {
        return this.elementArray.size();
    }

    public Iterator<MatrixValue> iterator() {
        return new MatrixIterator(this);
    }

    private class MatrixIterator implements Iterator<MatrixValue> {
        private MatrixResult mR;

        private int currentIndex = 0;

        public MatrixIterator(MatrixResult mR) {
            this.mR = mR;
        }

        public boolean hasNext() {
            return (this.currentIndex < this.mR.getSize());
        }

        public MatrixResult.MatrixValue next() {
            return new MatrixResult.MatrixValue(this.mR, this.currentIndex++);
        }
    }
}
