
let file = "/home/elias/Good_repos/advents/2020/data_inputs/01-2020.txt"

let slurp file =
  let reader = open_in file in
  let cur_str = really_input_string reader (in_channel_length reader) in
  close_in reader;

print_endline cur_str;

