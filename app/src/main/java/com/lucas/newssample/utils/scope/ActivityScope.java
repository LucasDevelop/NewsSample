package com.lucas.newssample.utils.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * 作者：lucas on 2016/6/24 11:47
 * 邮箱：lucas_developer@163.com
 * 说明：
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
