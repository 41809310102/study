package com.example.myblog.service;


import com.example.myblog.po.Type;

import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TypeService {
  Type saveType(Type type);
  Type checck(String name);
  Type getType(Long id);
  List<Type> listType();
  Page<Type> listType(Pageable pageable);
  Type updateType(Long id, Type type) throws NotFoundException;
  void deleteType(long id) throws NotFoundException;
}
