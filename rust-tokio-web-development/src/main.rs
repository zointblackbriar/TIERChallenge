// extern crate main; 
use rand::prelude::*;
use std::env; 




fn main() {
    println!("Hello, world!");

    let mut rng: ThreadRng = rand::thread_rng(); 
    let random_number = generate_float(&mut rng); 
    println!("random number: {}", random_number);

}

fn production_with_argument() {
    let args: Vec<String> = env::args().collect(); 
    // println!("interacting with cargo {:?}", args); //you can pass an argument
    let path: &str = &args[0];
    println!("show the path: {}", path);

    if path.contains("/debug/") {
        println!("The development application is running"); 
    }
    else if path.contains("/release") {
        println!("The production environment has been set"); 
    } 
    else 
    {
        panic!("The setting is neither development nor production");
    }

}


/// This function generates a float number using a number 
/// generator passed into the function 

/// # Arguments 
/// * generator (&mut ThreadRng): the random number 
/// generator to generate the random number
/// # Returns 
/// (f64): random number between 0 -> 10
fn generate_float(generator: &mut ThreadRng) -> f64 {
    let placeholder: f64 = generator.gen(); 
    println!("placeholder {}", placeholder);
    return placeholder * 10.0
}

/// This trait defines the struct to be a user.
trait IsUser {

    /// This function proclaims that the struct is a user.
    /// 
    /// # Arguments
    /// None
    /// # Returns 
    /// (bool) true if user, false if not

    fn is_user() -> bool {
        return true
    }
}

/// This struct defines a user
/// 
/// #Attributes
/// * name (String): the name of the user
/// * age(i8): the age of the user
struct User {
    name: String, 
    age: i8
}

