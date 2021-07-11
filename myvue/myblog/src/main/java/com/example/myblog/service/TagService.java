package com.example.myblog.service;


import com.example.myblog.po.Tag;

import com.example.myblog.po.Type;
import javassist.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TagService {
    Tag saveTag(Tag tag);
    Tag checck(String name);
    Tag getTag(Long id);
    List<Tag> listTag();
    Page<Tag> listTag(Pageable pageable);
    Tag updateTag(Long id, Tag tag) throws NotFoundException;
    void deleteTag(long id) throws NotFoundException;
    List<Tag> ListTag(String ids);
}
