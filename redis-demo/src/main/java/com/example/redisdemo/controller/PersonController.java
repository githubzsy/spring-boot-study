package com.example.redisdemo.controller;

import com.example.redisdemo.dao.PersonRepository;
import com.example.redisdemo.model.Person;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class PersonController {

    @Resource
    PersonRepository personRepository;

    /**
     * 第一次会进入代码，去查询redis。当有值时，便会缓存下来。第二次直接不进入方法体。
     * 缓存的内容其实还是记录在Redis上的
     * 实际上缓存更应该加在dao层
     * #id表示key值，value表示缓存的表的名称，同一对象应当相同
     * @param id
     * @return
     */
    @Cacheable(value="person",key = "#id")
    @GetMapping("/person/{id}")
    public Person get(@PathVariable String id){
        return personRepository.findById(id).get();
    }

    /**
     * 新增/修改之后用缓存存储，而且要删除personAll缓存
     * @param person
     * @return
     */
    @Caching(
            evict = {
                    // 删除personAll缓存
                    @CacheEvict(value = "personAll",allEntries = true),
                    // 删除当前对象缓存
                    @CacheEvict(value = "person",key = "#person.getId()")
            }
    )
    @PostMapping("/person")
    public void save(@RequestBody Person person){
        personRepository.save(person);
    }

    /**
     * 删除数据的同时也删除缓存
     * @param id
     */
    @Caching(
            evict = {
                    // 删除personAll缓存
                    @CacheEvict(value = "personAll",allEntries = true),
                    // 删除当前对象缓存
                    @CacheEvict(value = "person",key = "#id")
            }
    )
    @DeleteMapping("/person/{id}")
    public void delete(@PathVariable String id){
        personRepository.deleteById(id);
    }

    @Cacheable(value = "personAll")
    @GetMapping("/person")
    public List<Person> getAll(){
        return Lists.newArrayList(personRepository.findAll());
    }
}
