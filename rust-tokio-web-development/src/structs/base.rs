//We want to use our base struct within the module but not externally

pub struct Base {
    pub title: String,
    pub status: String
}

impl Base {
    pub fn new(input_title: &str, input_status: &str) -> Base { //return is Base type - , we have a standard struct with a constructor.
        return Base{title: input_title.to_string(), status: input_status.to_string()} //assignment to the struct
    }
}