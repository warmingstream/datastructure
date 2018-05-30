package com.baimawanglang.redpack.dao;

import com.baimawanglang.redpack.Record;

import java.util.List;

public interface RecordMapper {
    void save(Record record);

    List<Record> listRecords(String uuid);
}
