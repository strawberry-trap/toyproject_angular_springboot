package com.spring.toyproject_backend.v2.service;

import java.util.Optional;

public interface DatabaseErrorHandling<T, U> {

    T generateResultWithListEmptyCheck(Iterable<U> list); // Page, List's superinterface

    T generateResultWithOptionalEmptyCheck(Optional<U> record); // Optional's superinterface

}
