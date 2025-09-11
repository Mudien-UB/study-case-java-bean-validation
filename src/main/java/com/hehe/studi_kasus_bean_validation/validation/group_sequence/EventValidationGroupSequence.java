package com.hehe.studi_kasus_bean_validation.validation.group_sequence;

import com.hehe.studi_kasus_bean_validation.validation.group.BusinessRules;
import com.hehe.studi_kasus_bean_validation.validation.group.LimitChecks;
import com.hehe.studi_kasus_bean_validation.validation.group.RequiredChecks;
import jakarta.validation.GroupSequence;

@GroupSequence({RequiredChecks.class, BusinessRules.class, LimitChecks.class})
public interface EventValidationGroupSequence {

}
