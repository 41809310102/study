package com.example.myblog.service;


import com.example.myblog.dao.TypeRepository;
import com.example.myblog.po.Type;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


//实现增删改查
@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    private TypeRepository typeRepository;

    @Override
    public Type saveType(Type type) {
        return typeRepository.save(type);
    }

    @Override
    public Type checck(String name) {
        Type tag = typeRepository.findByname(name);
        return tag;
    }
    @Transactional
    @Override
    public Type getType(Long id) {
        return typeRepository.findById(id).get();
    }
    @Transactional
    @Override
    public List<Type> listType() {
        return typeRepository.findAll();
    }
    @Transactional
    @Override
    public Page<Type> listType(Pageable pageable) {
            return typeRepository.findAll(pageable);
    }

    @Override
    public List<Type> listTypeTop(Integer numbers) {
      Sort sort = Sort.by(Sort.Direction.DESC,"blogs.size");
      Pageable pageable = PageRequest.of(0,numbers,sort);
      return  typeRepository.findTop(pageable);
    }

    @Transactional
    @Override
    public Type updateType(Long id, Type type) throws NotFoundException {
        Type type1 = typeRepository.getById(id);
            if(type1==null){
                throw new NotFoundException("不存在该类型！");
            }
            BeanUtils.copyProperties(type,type1);
            return typeRepository.save(type1);
    }
    @Transactional
    @Override
    public void deleteType(long id) throws NotFoundException {
        Type type = typeRepository.getById(id);
        if(type ==null){
            throw new NotFoundException("不存在该类型！");
        }
        typeRepository.deleteById(id);
    }
}
