package com.yash.Joblisting.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.yash.Joblisting.model.Post;

@Repository
public interface PostDB extends MongoRepository<Post, String> {

}
