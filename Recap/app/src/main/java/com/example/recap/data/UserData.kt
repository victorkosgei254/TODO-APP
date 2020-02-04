package com.example.recap.data

import com.example.recap.models.User

class UserData {
    companion object{
        fun createDataSet():ArrayList<User>{
            val list = ArrayList<User>()
            list.add(User(username = "Victor Kosgei",contact = "victorkosgei254@gmail.com",profile = "https://avatars3.githubusercontent.com/u/37154833?s=460&v=4"))
            list.add(User(username = "Victor Mountains",contact = "victorkosgei254@gmail.com",profile = "https://image.shutterstock.com/image-photo/mountains-during-sunset-beautiful-natural-260nw-407021107.jpg"))
            list.add(User(username = "Victor Love",contact = "victorkosgei254@gmail.com",profile = "https://cdn.pixabay.com/photo/2015/04/23/22/00/tree-736885__340.jpg"))
            list.add(User(username = "Victor Kosgei",contact = "victorkosgei254@gmail.com",profile = "https://avatars3.githubusercontent.com/u/37154833?s=460&v=4"))


            return list
        }


    }
}