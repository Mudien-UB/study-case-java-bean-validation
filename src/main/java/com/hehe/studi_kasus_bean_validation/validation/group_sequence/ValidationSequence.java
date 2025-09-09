package com.hehe.studi_kasus_bean_validation.validation.group_sequence;

import com.hehe.studi_kasus_bean_validation.dto.AddressDto;
import com.hehe.studi_kasus_bean_validation.validation.group.AdvancedGroup;
import com.hehe.studi_kasus_bean_validation.validation.group.BasicGroup;
import jakarta.validation.GroupSequence;
import jakarta.validation.groups.Default;


/*
* JADI
* Kalau di AdvancedGroup ada eror akan berhenti, kalau tidak ada lanjut ke basic group dan seterusnya
*
* jadi tidak validasi sekaligus untuk nested nya, tapi group
*
* */

@GroupSequence({AdvancedGroup.class, BasicGroup.class, Default.class})
public interface ValidationSequence {

}
