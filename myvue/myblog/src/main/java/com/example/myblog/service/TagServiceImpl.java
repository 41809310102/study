package com.example.myblog.service;


import com.example.myblog.dao.TagsRepository;
import com.example.myblog.po.Tag;
import javassist.NotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;


@Service
public class TagServiceImpl  implements TagService{
    @Autowired
    private TagsRepository tagsRepository;


    @Transactional
    @Override
    public Tag saveTag(Tag tag) {
        return tagsRepository.save(tag);
    }
    @Transactional
    @Override
    public Tag checck(String name) {
      Tag tag = tagsRepository.findByname(name);
      return tag;
    }
    @Transactional
    @Override
    public Tag getTag(Long id) {
        return tagsRepository.findById(id).get();
    }

    @Override
    public List<Tag> listTag() {
        return tagsRepository.findAll();
    }

    @Transactional
    @Override
    public Page<Tag> listTag(Pageable pageable) {
       return tagsRepository.findAll(pageable);
    }
    @Transactional
    @Override
    public Tag updateTag(Long id, Tag tag) throws NotFoundException {
    Tag tag1 = tagsRepository.getById(id);
    if(tag1==null){
        throw new NotFoundException("不存在该类型！");
    }
        BeanUtils.copyProperties(tag,tag1);
        return tagsRepository.save(tag1);
    }
    @Transactional
    @Override
    public void deleteTag(long id) throws NotFoundException {
      Tag tag = tagsRepository.getById(id);
      if(tag==null){
          throw new NotFoundException("不存在该类型！");
      }
     tagsRepository.deleteById(id);
    }
//获得标签的类别
    @Override
    public List<Tag> ListTag(String ids) {
        return tagsRepository.findAllById(conver(ids));
    }

    //将字符串转化为id数组

   private List<Long> conver(String s){
        List<Long> list = new ArrayList<>();
        if(!s.equals("")&&s!=null){
            String[] arr = s.split(",");
            for(int i = 0;i<arr.length;i++){
                list.add(new Long(arr[i]));
            }
        }
        return list;
   }

}
