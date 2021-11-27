
let input_file_elf = "/home/elias/Good_repos/advents/2020/data_inputs/01-2020.txt";;

(* [@@@ocaml.warning "-27"] *)
let slurp file =
  let reader = open_in file in
  let cur_str = really_input_string reader (in_channel_length reader) in
  close_in reader;
  print_endline cur_str

(* slurp input_file_elf; *)

(* open Batteries

   let lines = File.lines_of input_file_elf 
   Enum.iter (fun line -> 
    let a int_of_string line in
    print_int a
    ) lines
*)

open Core

let () = 
  let file_to_read = input_file_elf in
  let lines = In_channel.read_lines file_to_read in
  (* print_endline (concat lines); *)
  let digits = List.map ~f:int_of_string lines in
  List.iter ~f:(fun line ->
      let a = int_of_string line in
      print_endline (string_of_int a)
    ) lines;
  print_endline "\nwith map ->";
  List.iter ~f:(printf "%d\n") digits;
  let count = List.length digits in
  printf "number of digits --> %d\n" count;



